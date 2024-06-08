import { createRouter, createWebHistory } from "vue-router";
import LoginPage from "./components/pages/LoginPage.vue";
import RegisterPage from "./components/pages/RegisterPage.vue";
import TransferFundsPage from "./components/pages/TransferFundsPage.vue";
import TransferBetweenAccountsPage from "./components/pages/TransferBetweenAccountsPage.vue";
import CustomerDashboard from "./components/pages/CustomerDashboard.vue";
import TransactionsOverview from "./components/pages/TransactionsOverview.vue";
import AccountDetails from "./components/pages/AccountDetails.vue";
import AccountsPage from "./components/pages/AccountsPage.vue";

const routes = [
  { path: "/", component: LoginPage },
  { path: "/register", component: RegisterPage },
  { path: "/transfer-funds", component: TransferFundsPage },
  {
    path: "/transfer-between-accounts",
    component: TransferBetweenAccountsPage,
  },
  { path: "/dashboard/overview", component: CustomerDashboard },
  { path: "/dashboard/transactions", component: TransactionsOverview },
  { path: "/dashboard/account-details", component: AccountDetails },
  { path: "/dashboard/accounts", component: AccountsPage },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
