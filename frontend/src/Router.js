import { createMemoryHistory, createRouter } from "vue-router";

import HomePage from "./components/pages/HomePage.vue";
import ApiTestPage from "./components/pages/ApiTestPage.vue";
import LoginPage from "./components/pages/LoginPage.vue";
import ATM from "./components/pages/ATMpage.vue";

const routes = [
  { path: "/", component: HomePage },
  { path: "/api-test", component: ApiTestPage },
  { path: "/login", component: LoginPage },
  { path: "/atm", component: ATM },
];

const router = createRouter({
  history: createMemoryHistory(),
  routes,
});

export default router;
