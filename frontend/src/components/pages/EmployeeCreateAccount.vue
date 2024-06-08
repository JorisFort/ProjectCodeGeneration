<script setup>
import EmployeeNavigation from "../common/EmployeeNavigation.vue";
import EmployeeCreateAccountForm from "../containers/EmployeeCreateAccountForm.vue";
</script>

<template>
  <div class="employeeNavBar">
    <EmployeeNavigation />
  </div>
  <div class="employeeContent">
    <EmployeeCreateAccountForm/>
  </div>
</template>
