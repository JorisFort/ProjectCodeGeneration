<script setup>
import EmployeeNavigation from "../common/EmployeeNavigation.vue";
import EmployeeTransactionOverview from "../containers/EmployeeTransactionOverview.vue"
</script>

<template>

  <div class="employeeNavBar">
    <EmployeeNavigation />
  </div>
  <div class="employeeContent">
    <EmployeeTransactionOverview/>
  </div>

</template>
