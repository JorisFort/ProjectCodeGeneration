<script setup>
import EmployeeNavigation from "../common/EmployeeNavigation.vue";
import EmployeeCustomerTransactions from "../containers/EmployeeCustomerTransactionsOverview.vue";
import {useRoute} from "vue-router";
const id = useRoute().params.id;
</script>

<template>

  <div class="employeeNavBar">
    <EmployeeNavigation />
  </div>
  <div class="employeeContent">
    <div>
      <router-link :to="{ name: 'EmployeeCustomerDetail', params: { id: id }}" class="backButton"><button>Back</button></router-link>
    </div>
    <div>
      <EmployeeCustomerTransactions :id="id.toString()"/>
    </div>
  </div>

</template>