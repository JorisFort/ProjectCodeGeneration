<template>
  <div class="account-balance">
    <h3>Current Account Balance</h3>
    <div class="balance-info">
      <div class="balance-item">
        <span>Current Balance</span>
        <h2>€ {{state.balance}}</h2>
      </div>
    </div>
  </div>
</template>

<script setup>
import {reactive, onMounted} from "vue";
import {getAllAccountsFromCustomer} from "@/services/AccountService.js";

const state = reactive({
  balance: "",
});

onMounted(async () => {
  const user = JSON.parse(localStorage.getItem('user'));
  const accounts = await getAllAccountsFromCustomer(user.id);

  if (accounts) {
    state.balance = accounts.reduce((total, account) => total + account.balance, 0);
  }
});

</script>

<style scoped>
.account-balance {
  background: #e0f7fa;
  padding: 1rem;
  border-radius: 10px;
  margin-bottom: 1rem;
}

.balance-info {
  display: flex;
  justify-content: space-between;
}

.balance-item {
  text-align: center;
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
