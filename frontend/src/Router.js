import { createMemoryHistory, createRouter } from "vue-router";
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

const routes = [
    { path: "/", component: LoginPage },
    { path: "/register", component: RegisterPage },
    { path: "/transfer-funds", component: TransferFundsPage },
    {path: "/transfer-between-accounts", component: TransferBetweenAccountsPage,},
    { path: "/dashboard/overview", component: CustomerDashboard },
    { path: "/dashboard/transactions", component: TransactionsOverview },
    { path: "/dashboard/account-details", component: AccountDetails },
    { path: "/dashboard/accounts", component: AccountsPage },
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
    { path: "/employeeCustomerTransactions/:id", name: 'EmployeeCustomerTransactions', component: EmployeeCustomerTransactions}
];

const router = createRouter({
  history: createMemoryHistory(),
  routes,
});

export default router;
