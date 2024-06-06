// src/Router.js
import { createRouter, createWebHistory } from "vue-router";
import HomePage from "./components/pages/HomePage.vue";
import ApiTestPage from "./components/pages/ApiTestPage.vue";
import LoginPage from "./components/pages/LoginPage.vue";
import RegisterPage from "./components/pages/RegisterPage.vue";
import TransferFundsPage from "./components/pages/TransferFundsPage.vue";
import TransferBetweenAccountsPage from "./components/pages/TransferBetweenAccountsPage.vue";
import CustomerDashboard from "./components/pages/CustomerDashboard.vue";
import TransactionsOverview from "./components/pages/TransactionsOverview.vue";
import AccountDetails from "./components/pages/AccountDetails.vue"; // Ensure this import is correct

const routes = [
  { path: "/", component: HomePage },
  { path: "/api-test", component: ApiTestPage },
  { path: "/login", component: LoginPage },
  { path: "/register", component: RegisterPage },
  { path: "/transfer-funds", component: TransferFundsPage },
  {
    path: "/transfer-between-accounts",
    component: TransferBetweenAccountsPage,
  },
  { path: "/dashboard/overview", component: CustomerDashboard },
  { path: "/dashboard/transactions", component: TransactionsOverview },
  { path: "/dashboard/account-details", component: AccountDetails }, // Ensure this route is correct
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
