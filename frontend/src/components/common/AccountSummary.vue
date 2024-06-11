<template>
  <div class="account-summary">
    <h3>Accounts</h3>
    <div class="account-item">
      <span>Checking</span>
      <h2>€ {{state.checkingBalance}}</h2>
    </div>
    <div class="account-item">
      <span>Savings</span>
      <h2>€ {{state.savingsBalance}}</h2>
    </div>
  </div>
</template>

<script setup>
import {reactive} from "vue";
import {onMounted} from 'vue';
import {getAllAccountsFromCustomer} from "@/services/AccountService.js";

const state = reactive({
  checkingBalance: "",
  savingsBalance: "",
});

onMounted(async () => {
  const user = JSON.parse(localStorage.getItem('user'));
  const accounts = await getAllAccountsFromCustomer(user.id);

  if (accounts) {
    state.checkingBalance = accounts.find(a => a.accountType === 'CHECKING')?.balance;
    state.savingsBalance = accounts.find(a => a.accountType === 'SAVINGS')?.balance;
  }
});
</script>

<style scoped>
.account-summary {
  display: flex;
  justify-content: space-between;
  margin-bottom: 1rem;
}

.account-item {
  background: #e0f7fa;
  padding: 1rem;
  border-radius: 10px;
  flex: 1;
  margin: 0 0.5rem;
  text-align: center;
}

.account-item:first-child {
  margin-left: 0;
}

.account-item:last-child {
  margin-right: 0;
}

h3 {
  margin-bottom: 1rem;
}

h2 {
  margin: 0;
  font-size: 1.5rem;
}

span {
  display: block;
  margin-bottom: 0.5rem;
}
</style>
