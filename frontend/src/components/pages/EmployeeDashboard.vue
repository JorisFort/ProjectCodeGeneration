<script setup>
import TotalAccounts from "../containers/TotalAccounts.vue";
import PendingSignUps from "../containers/PendingSignUps.vue";
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
