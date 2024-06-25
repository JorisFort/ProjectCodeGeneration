<script setup>
import TotalAccounts from "../../containers/customerDashboard/TotalAccounts.vue";
import PendingSignUps from "../../containers/employeeDashboard/PendingSignUps.vue";
</script>

<template>
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
</template>
