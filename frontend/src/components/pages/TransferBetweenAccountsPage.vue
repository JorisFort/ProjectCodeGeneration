<template>
  <div class="transfer-between-accounts-page">
    <Sidebar/>
    <div class="main-content">
      <TransferBetweenAccountsForm/>
    </div>
  </div>
</template>

<script setup>
//import Sidebar from "../CustomerNavigation.vue";
import TransferBetweenAccountsForm from "../containers/dashboard/transaction/TransferBetweenAccountsForm.vue";
</script>

<style scoped>
.transfer-between-accounts-page {
  display: flex;
  min-height: 100vh;
  background-color: #f7f9fc;
}

.main-content {
  flex: 1;
  padding: 2rem;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
