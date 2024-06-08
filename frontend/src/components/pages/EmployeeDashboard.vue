<script setup>
import EmployeeNavigation from "../common/EmployeeNavigation.vue";
import TotalAccounts from "../containers/TotalAccounts.vue";
import PendingSignUps from "../containers/PendingSignUps.vue";
</script>

<template>
    <div class="employeeNavBar"><EmployeeNavigation /></div>
    <div class="employeeContent">
      <div class="grid">
        <TotalAccounts/>
        <PendingSignUps/>
      </div>
      <div class="grid">
        <div id="dashboardTransactionChart">
          <!--   <TransactionChart />   -->
        </div>
        <div id="dashboardNewAccountChart">
          <!--   <NewAccountChart />   -->
        </div>
      </div>
    </div>
</template>
