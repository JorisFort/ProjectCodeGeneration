<template>
  <div class="accounts-page">
    <h1>Accounts</h1>
    <div class="account-section" v-for="account in accounts" :key="account.id">
      <div class="account-header">
        <h2>{{ account.name }}</h2>
        <p>Balance: {{ account.balance }}</p>
      </div>
      <div class="account-details">
        <p><strong>IBAN:</strong> {{ account.iban }}</p>
        <button class="view-button" @click="viewAccount(account)">View</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";

const accounts = ref([
  {
    id: 1,
    name: "Checking",
    balance: "$2,500.00",
    iban: "GB29NWBK60161331926819",
  },
  {
    id: 2,
    name: "Savings",
    balance: "$10,000.00",
    iban: "GB29NWBK60161331926820",
  },
]);

const router = useRouter();

const viewAccount = (account) => {
  router.push({
    path: "/dashboard/transactions",
    params: {
      name: account.name,
      balance: account.balance,
      iban: account.iban,
    },
  });
};
</script>

<style scoped>
.accounts-page {
  max-width: 1200px; /* Increased max-width for more space */
  margin: 0 auto;
  padding: 2rem;
}

.account-section {
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
</style>
