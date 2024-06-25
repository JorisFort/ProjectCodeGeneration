import {createRouter, createWebHistory} from "vue-router";
import LoginPage from "./components/pages/LoginPage.vue";
import RegisterPage from "./components/pages/RegisterPage.vue";
import TransferFundsPage from "./components/pages/TransferFundsPage.vue";
import TransferBetweenAccountsPage from "./components/pages/TransferBetweenAccountsPage.vue";
import CustomerDashboard from "./components/pages/customer/CustomerDashboard.vue";
import TransactionsOverview from "./components/pages/TransactionsOverview.vue";
import AccountDetails from "./components/pages/AccountDetails.vue";
import AccountsPage from "./components/pages/AccountsPage.vue";
import EmployeeDashboard from "./components/pages/EmployeeDashboard.vue";
import EmployeeTransaction from "./components/pages/EmployeeTransactions.vue"
import EmployeeCustomers from "./components/pages/EmployeeCustomers.vue";
import EmployeeTransfer from "./components/pages/EmployeeTransfer.vue";
import EmployeeCreateAccount from "./components/pages/EmployeeCreateAccount.vue";
import EmployeeSignups from "./components/pages/EmployeeSignups.vue";
import EmployeeAccount from "./components/pages/EmployeeAccount.vue";
import EmployeeEditAccount from "./components/pages/EmployeeEditAccount.vue";
import EmployeeCustomerDetail from "./components/pages/EmployeeCustomerDetail.vue";
import EmployeeCustomerChangeDetail from "./components/pages/EmployeeCustomerChangeDetail.vue";
import EmployeeCustomerTransactions from "./components/pages/EmployeeCustomerTransactions.vue";
import ATMPage from "./components/pages/ATMpage.vue";

const routes = [
    {path: "/login", component: LoginPage},
    {path: "/register", component: RegisterPage},
    {path: "/transfer-funds", component: TransferFundsPage, meta: {requiresAuth: true, role: 'customer'}},
    {
        path: "/transfer-between-accounts",
        component: TransferBetweenAccountsPage,
        meta: {requiresAuth: true, role: 'customer'}
    },
    {path: "/customerDashboard", component: CustomerDashboard, meta: {requiresAuth: true, role: 'customer'}},
    {path: "/dashboard/transactions", component: TransactionsOverview, meta: {requiresAuth: true, role: 'customer'}},
    {path: "/customerProfile", component: AccountDetails, meta: {requiresAuth: true, role: 'customer'}},
    {path: "/customerAccounts", component: AccountsPage, meta: {requiresAuth: true, role: 'customer'}},
    {path: "/employeeDashboard", component: EmployeeDashboard, meta: {requiresAuth: true, role: 'employee'}},
    {path: "/employeeTransactions", component: EmployeeTransaction, meta: {requiresAuth: true, role: 'employee'}},
    {path: "/employeeCustomers", component: EmployeeCustomers, meta: {requiresAuth: true, role: 'employee'}},
    {path: "/employeeTransfer", component: EmployeeTransfer, meta: {requiresAuth: true, role: 'employee'}},
    {path: "/employeeCreateAccount", component: EmployeeCreateAccount, meta: {requiresAuth: true, role: 'employee'}},
    {path: "/employeeSignups", component: EmployeeSignups, meta: {requiresAuth: true, role: 'employee'}},
    {path: "/employeeAccount", component: EmployeeAccount, meta: {requiresAuth: true, role: 'employee'}},
    {path: "/employeeEditAccount", component: EmployeeEditAccount, meta: {requiresAuth: true, role: 'employee'}},
    {
        path: "/employeeCustomerDetail/:id",
        name: 'EmployeeCustomerDetail',
        component: EmployeeCustomerDetail,
        meta: {requiresAuth: true, role: 'employee'}
    },
    {
        path: "/employeeCustomerChangeDetail/:id",
        name: 'EmployeeCustomerChangeDetail',
        component: EmployeeCustomerChangeDetail,
        meta: {requiresAuth: true, role: 'employee'}
    },
    {
        path: "/employeeCustomerTransactions/:id",
        name: 'EmployeeCustomerTransactions',
        component: EmployeeCustomerTransactions,
        meta: {requiresAuth: true, role: 'employee'}
    },
    {path: "/atm", component: ATMPage, meta: {requiresAuth: true, role: 'customer'}}
];

const router = createRouter({
    history: createWebHistory(),
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

const redirectToDashboard = (role, from, next) => {
    if (role === 'EMPLOYEE' && from.path === '/employeeDashboard') {
        next({path: '/employeeDashboard'});
    } else if (role === 'CUSTOMER' && from.path === '/customerDashboard') {
        next({path: '/customerDashboard'});
    } else {
        next();
    }
};

router.beforeEach((to, from, next) => {
    if (!to.meta.requiresAuth && to.path !== '/') {
        next();
    } else if (!isAuthenticated()) {
        next({path: '/login'});
    } else {
        const userRole = getUserRole();
        const toRole = to.meta.role;
        if (toRole && toRole !== userRole) {
            redirectToDashboard(userRole, from, next);
        } else {
            next();
        }
    }
});

export default router;