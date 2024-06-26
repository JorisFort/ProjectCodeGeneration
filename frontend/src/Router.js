import { createRouter, createWebHistory } from "vue-router";
import LoginPage from "./components/pages/login/LoginPage.vue";
import RegisterPage from "./components/pages/login/RegisterPage.vue";
import TransferFundsPage from "./components/pages/customerDashboard/TransferFundsPage.vue";
import TransferBetweenAccountsPage from "./components/pages/customerDashboard/TransferBetweenAccountsPage.vue";
import CustomerDashboard from "./components/pages/customerDashboard/CustomerDashboard.vue";
import TransactionsOverview from "./components/pages/customerDashboard/Accounts/TransactionsOverview.vue";
import AccountDetails from "./components/pages/customerDashboard/AccountDetails.vue";
import AccountsPage from "./components/pages/customerDashboard/AccountsPage.vue";
import EmployeeDashboard from "./components/pages/employee/EmployeeDashboard.vue";
import EmployeeTransaction from "./components/pages/employee/EmployeeTransactions.vue";
import EmployeeCustomers from "./components/pages/employee/EmployeeCustomers.vue";
import EmployeeTransfer from "./components/pages/employee/EmployeeTransfer.vue";
import EmployeeCreateAccount from "./components/pages/employee/EmployeeCreateAccount.vue";
import EmployeeSignups from "./components/pages/employee/EmployeeSignups.vue";
import EmployeeAccount from "./components/pages/employee/EmployeeAccount.vue";
import EmployeeEditAccount from "./components/pages/employee/EmployeeEditAccount.vue";
import EmployeeCustomerDetail from "./components/pages/employee/EmployeeCustomerDetail.vue";
import EmployeeCustomerChangeDetail from "./components/pages/employee/EmployeeCustomerChangeDetail.vue";
import EmployeeCustomerTransactions from "./components/pages/employee/EmployeeCustomerTransactions.vue";
import ATMPage from "./components/pages/atm/ATMpage.vue";

const routes = [
    { path: "/login", component: LoginPage },
    { path: "/register", component: RegisterPage },
    { path: "/transfer-funds", component: TransferFundsPage, meta: { requiresAuth: true, role: "ROLE_CUSTOMER" } },
    {
        path: "/transfer-between-accounts",
        component: TransferBetweenAccountsPage,
        meta: { requiresAuth: true, role: "ROLE_CUSTOMER" }
    },
    { path: "/customerDashboard", component: CustomerDashboard, meta: { requiresAuth: true, role: "ROLE_CUSTOMER" } },
    { path: "/dashboard/transactions/:accountId", name: "Transactions", component: TransactionsOverview, meta: { requiresAuth: true, role: "ROLE_CUSTOMER" }, props: true },
    { path: "/customerProfile", component: AccountDetails, meta: { requiresAuth: true, role: "ROLE_CUSTOMER" } },
    { path: "/customerAccounts", component: AccountsPage, meta: { requiresAuth: true, role: "ROLE_CUSTOMER" } },
    { path: "/employeeDashboard", component: EmployeeDashboard, meta: { requiresAuth: true, role: "ROLE_EMPLOYEE" } },
    { path: "/employeeTransactions", component: EmployeeTransaction, meta: { requiresAuth: true, role: "ROLE_EMPLOYEE" } },
    { path: "/employeeCustomers", component: EmployeeCustomers, meta: { requiresAuth: true, role: "ROLE_EMPLOYEE" } },
    { path: "/employeeTransfer", component: EmployeeTransfer, meta: { requiresAuth: true, role: "ROLE_EMPLOYEE" } },
    { path: "/employeeCreateAccount", component: EmployeeCreateAccount, meta: { requiresAuth: true, role: "ROLE_EMPLOYEE" } },
    { path: "/employeeSignups", component: EmployeeSignups, meta: { requiresAuth: true, role: "ROLE_EMPLOYEE" } },
    { path: "/employeeAccount", component: EmployeeAccount, meta: { requiresAuth: true, role: "ROLE_EMPLOYEE" } },
    { path: "/employeeEditAccount", component: EmployeeEditAccount, meta: { requiresAuth: true, role: "ROLE_EMPLOYEE" } },
    {
        path: "/employeeCustomerDetail/:id",
        name: "EmployeeCustomerDetail",
        component: EmployeeCustomerDetail,
        meta: { requiresAuth: true, role: "ROLE_EMPLOYEE" }
    },
    {
        path: "/employeeCustomerChangeDetail/:id",
        name: "EmployeeCustomerChangeDetail",
        component: EmployeeCustomerChangeDetail,
        meta: { requiresAuth: true, role: "ROLE_EMPLOYEE" }
    },
    {
        path: "/employeeCustomerTransactions/:id",
        name: "EmployeeCustomerTransactions",
        component: EmployeeCustomerTransactions,
        meta: { requiresAuth: true, role: "ROLE_EMPLOYEE" }
    },
    { path: "/atm", component: ATMPage, meta: { requiresAuth: true, role: "ROLE_CUSTOMER" } }
];

const router = createRouter({
    history: createWebHistory('/ProjectCodeGeneration/'),
    routes,
});

const isAuthenticated = () => !!localStorage.getItem('jwtToken');

const getUserRole = () => {
    let user;
    try {
        user = JSON.parse(localStorage.getItem('user'));
    } catch (error) {
        console.error('Error parsing user data from localStorage:', error);
    }
    return user ? user.role : null;
};

router.beforeEach((to, from, next) => {
    if (!isAuthenticated()) {
        if (to.path !== '/login' && to.path !== '/register') {
            next({ path: '/login' });
        } else {
            next();
        }
    } else {
        const userRole = getUserRole();
        const toRole = to.meta.role;

        if (toRole && toRole !== userRole) {
            if (userRole === 'ROLE_EMPLOYEE') {
                next({ path: '/employeeDashboard' });
            } else if (userRole === 'ROLE_CUSTOMER') {
                next({ path: '/customerDashboard' });
            } else {
                next({ path: '/login' });
            }
        } else {
            next();
        }
    }
});

export default router;
