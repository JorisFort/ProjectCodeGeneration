import {createRouter, createWebHistory} from "vue-router";
import LoginPage from "./components/pages/LoginPage.vue";
import RegisterPage from "./components/pages/RegisterPage.vue";
import TransferFundsPage from "./components/pages/TransferFundsPage.vue";
import TransferBetweenAccountsPage from "./components/pages/TransferBetweenAccountsPage.vue";
import CustomerDashboard from "./components/pages/CustomerDashboard.vue";
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
import ATMpage from "./components/pages/ATMpage.vue";

const routes = [
    { path: "/", component: LoginPage },
    { path: "/register", component: RegisterPage },
    { path: "/transfer-funds", component: TransferFundsPage },
    { path: "/transfer-between-accounts", component: TransferBetweenAccountsPage,},
    { path: "/customerDashboard", component: CustomerDashboard },
    { path: "/dashboard/transactions", component: TransactionsOverview },
    { path: "/customerProfile", component: AccountDetails },
    { path: "/customerAccounts", component: AccountsPage },
    { path: "/employeeDashboard", component: EmployeeDashboard},
    { path: "/employeeTransactions", component: EmployeeTransaction},
    { path: "/employeeCustomers", component: EmployeeCustomers},
    { path: "/employeeTransfer", component: EmployeeTransfer},
    { path: "/employeeCreateAccount", component: EmployeeCreateAccount},
    { path: "/employeeSignups", component: EmployeeSignups},
    { path: "/employeeAccount", component: EmployeeAccount},
    { path: "/employeeEditAccount", component: EmployeeEditAccount },
    { path: "/employeeCustomerDetail/:id", name: 'EmployeeCustomerDetail', component: EmployeeCustomerDetail},
    { path: "/employeeCustomerChangeDetail/:id", name: 'EmployeeCustomerChangeDetail', component: EmployeeCustomerChangeDetail},
    { path: "/employeeCustomerTransactions/:id", name: 'EmployeeCustomerTransactions', component: EmployeeCustomerTransactions},
    { path: "/atm", component: ATMpage}
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
