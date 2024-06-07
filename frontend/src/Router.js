import { createMemoryHistory, createRouter } from "vue-router";

import HomePage from "./components/pages/HomePage.vue";
import ApiTestPage from "./components/pages/ApiTestPage.vue";
import EmployeeDashboard from "./components/pages/EmployeeDashboard.vue";
import EmployeeTransaction from "./components/pages/EmployeeTransactions.vue"
import EmployeeCustomers from "./components/pages/EmployeeCustomers.vue";
import EmployeeTransfer from "./components/pages/EmployeeTransfer.vue";
import EmployeeCreateAccount from "./components/pages/EmployeeCreateAccount.vue";
import EmployeeSignups from "./components/pages/EmployeeSignups.vue";
import EmployeeAccount from "./components/pages/EmployeeAccount.vue";
import EmployeeEditAccount from "./components/pages/EmployeeEditAccount.vue";
import EmployeeCustomerDetail from "./components/pages/EmployeeCustomerDetail.vue";
import EmployeeCustomerTransactions from "./components/pages/EmployeeCustomerTransactions.vue";
import EmployeeCustomerChangeDetail from "./components/pages/EmployeeCustomerChangeDetail.vue";

const routes = [
  { path: "/", component: HomePage },
  { path: "/api-test", component: ApiTestPage },
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
  { path: "/employeeCustomerTransactions/:id/:name", name: 'EmployeeCustomerTransactions', component: EmployeeCustomerTransactions}
];

const router = createRouter({
  history: createMemoryHistory(),
  routes,
});

export default router;
