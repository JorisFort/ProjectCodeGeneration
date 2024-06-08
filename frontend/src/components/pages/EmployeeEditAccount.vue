<script setup>
import EmployeeNavigation from "../common/EmployeeNavigation.vue";
import EmployeeChangeAccountForm from "../containers/EmployeeChangeAccountForm.vue";
</script>

<template>
  <div class="employeeNavBar">
    <EmployeeNavigation />
  </div>
  <div class="employeeContent">
    <div>
      <router-link to="/EmployeeAccount" class="backButton"><button>Back</button></router-link>
    </div>
    <EmployeeChangeAccountForm/>
  </div>
</template>
