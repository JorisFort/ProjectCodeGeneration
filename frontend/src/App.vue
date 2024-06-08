<script setup>
import CustomerNavigation from "./components/common/CustomerNavigation.vue";
import EmployeeNavigation from "./components/common/EmployeeNavigation.vue";
import {ref} from "vue";
import { useRouter } from 'vue-router';

/*Temporary*/
const choiceMade = ref(false);
const customer = ref(false);
const employee = ref(false);
const atm = ref(false);
const router = useRouter();
const customerClick = () => {
  choiceMade.value = true;
  customer.value = true;
  router.push('/customerDashboard');
}
const employeeClick = () => {
  choiceMade.value = true;
  employee.value = true;
  router.push('/employeeDashboard');
}
const atmClick = () => {
  choiceMade.value = true;
  atm.value = true;
  router.push('/atm')
}
</script>

<template>
<!--  Temporary-->
  <div v-if="!choiceMade">
    <h1>Choose view:</h1>
    <button @click="customerClick">Customer</button>
    <button @click="employeeClick">Employee</button>
    <button @click="atmClick">ATM</button>
  </div>
  <div id="app" v-if="customer">
    <CustomerNavigation />
    <div class="content">
      <router-view></router-view>
    </div>
  </div>
  <div v-if="employee">
    <div class="employeeNavBar">
      <EmployeeNavigation/>
    </div>
    <div class="employeeContent">
      <router-view></router-view>
    </div>
  </div>
  <div v-if="atm">
    <router-view></router-view>
  </div>
</template>

<style scoped>
#app {
  display: flex; /* Flexbox to align sidebar and content */
  height: 100vh; /* Full viewport height */
}

.content {
  flex: 1; /* Takes up the remaining space */
  overflow-y: auto; /* Adds scrolling to the main content only */
}
</style>
