<script setup>
import EmployeeNavigation from "../common/EmployeeNavigation.vue";
import EmployeeCustomerDetailOverview from "../containers/EmployeeCustomerDetailOverview.vue";

import {useRoute} from "vue-router";
const id = useRoute().params.id;

</script>

<template>

  <div class="employeeNavBar">
    <EmployeeNavigation />
  </div>
  <div class="employeeContent">
    <div>
      <router-link to="/EmployeeCustomers" class="backButton"><button>Back</button></router-link>
    </div>
    <div>
      <EmployeeCustomerDetailOverview :id = "id"/>
    </div>
    <div class="grid">
    </div>

  </div>

</template>