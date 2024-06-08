<script setup>
import EmployeeNavigation from "../common/EmployeeNavigation.vue";
import CustomersOverview from "../containers/CustomersOverview.vue";
</script>

<template>

  <div class="employeeNavBar">
    <EmployeeNavigation />
  </div>
  <div class="employeeContent">
    <CustomersOverview />
  </div>

</template>
