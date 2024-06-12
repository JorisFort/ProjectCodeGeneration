<template>
  <div class="dashboard">
    <Sidebar/>
    <div class="main-content">
      <header class="header">
        <h1>Accounts</h1>
      </header>
      <div v-for="account in accounts" :key="account.id" class="content">
        <div class="account-header">
          <h2>{{ account.accountType }}</h2>
          <p>Balance: € {{ account.balance }}</p>
        </div>
        <div class="account-details">
          <p><strong>IBAN:</strong> {{ account.iban }}</p>
          <button class="view-button" @click="viewAccount(account)">View</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import Sidebar from "../common/CustomerNavigation.vue";
import {onMounted, ref} from "vue";
import {useRouter} from "vue-router";
import {getAllAccountsFromCustomer} from "@/services/AccountService.js";

const accounts = ref([]);

onMounted(async () => {
  const user = JSON.parse(localStorage.getItem('user'));
  accounts.value = await getAllAccountsFromCustomer(user.id);
});

const router = useRouter();

const viewAccount = (account) => {
  console.log(account);
  router.push({
    path: "/dashboard/transactions",
    params: {
      account: account
    },
  });
};
</script>

<style scoped>
.dashboard {
  display: flex;
}

.main-content {
  flex: 1;
  padding: 2rem;
  background: #f7f9fc;
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

.account-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: 1px solid #ccc;
  padding-bottom: 0.5rem;
}

.account-details {
  margin-top: 1rem;
}

.account-details p {
  margin: 0.5rem 0;
}

.view-button {
  background-color: #28a745;
  color: white;
  padding: 0.5rem 1rem;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 1rem;
  transition: background-color 0.3s;
  margin-top: 1rem;
}

.view-button:hover {
  background-color: #218838;
}



.main-content {
  flex: 1;
  padding: 2rem;
  background: #f7f9fc;
}



.content {
  display: flex;
  flex-direction: column;
}
</style>
