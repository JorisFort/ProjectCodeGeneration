<template>
  <div class="dashboard">
    <Sidebar/>
    <div class="main-content">
      <header class="header">
        <h1>Checking Account Transactions</h1>
        <div class="user-info">
          <span class="username">{{state.name}}</span>
          <span class="account-number">{{state.id}}</span>
        </div>
      </header>
      <div class="content">
        <h2>Account Balance: € {{ state.balance }}</h2>
        <p><strong>IBAN:</strong> {{state.iban}}</p>
      </div>
      <TransactionList/>
    </div>
  </div>
</template>

<script setup>
import TransactionList from "../containers/dashboard/transaction/TransactionList.vue";
import Sidebar from "../common/CustomerNavigation.vue";
import { onMounted, reactive } from 'vue';
import { useRoute} from "vue-router";
import {getCustomer} from "@/services/CustomerService.js";

const state = reactive({
  name: "",
  id: "",
  balance: 0,
  iban: ""
});

const route = useRoute();

onMounted(async() => {
  const user = JSON.parse(localStorage.getItem('user'));
  const customer = await getCustomer(user.id);

  state.name = customer.firstName + ' ' + customer.lastName;
  state.id = user.id;

  const account = route.params.account;

  console.log(account);

  state.balance = account.balance;
  state.iban = account.iban;
});


</script>

<style scoped>
.dashboard {
  display: flex;
}

.main-content {
  flex: 1;
  padding: 2rem;
  background: #f7f9fc;
  width: 100%;
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 2rem;
}

.content {
  background: #ffffff;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  margin-bottom: 2rem;
  padding: 2rem; /* Increased padding */
}

.content {
  background: #ffffff;
  padding: 2rem;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  margin-bottom: 2rem;
}

.user-info {
  text-align: right;
}

.username {
  display: block;
  font-weight: bold;
}

.account-number {
  display: block;
  color: #999;
}
</style>
