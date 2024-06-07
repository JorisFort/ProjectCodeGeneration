<template>
  <div class="transfer-between-accounts-form">
    <h2>Transfer</h2>
    <form @submit.prevent="handleTransfer">
      <div class="input-group">
        <label for="account">Transfer to</label>
        <select id="account" v-model="account" required>
          <option disabled value="">Account Name</option>
          <option>Checking</option>
          <option>Savings</option>
        </select>
      </div>
      <div class="input-group">
        <label for="amount">Amount</label>
        <input
          type="text"
          id="amount"
          v-model="amount"
          placeholder="100,000"
          required
        />
      </div>
      <div class="input-group">
        <label for="description">Description</label>
        <input
          type="text"
          id="description"
          v-model="description"
          placeholder="Enter description"
          required
        />
      </div>
      <div class="button-group">
        <button type="button" class="cancel">Cancel</button>
        <button type="submit" class="transfer">Transfer</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from "vue";

const account = ref("");
const amount = ref("");
const description = ref("");

const handleTransfer = () => {
  // Transfer logic here
  console.log("Account:", account.value);
  console.log("Amount:", amount.value);
  console.log("Description:", description.value);
};
</script>

<style scoped>
.transfer-between-accounts-form {
  max-width: 800px;
  margin: 1rem auto;
  padding: 1rem;
  border: 1px solid #ccc;
  border-radius: 5px;
  background: #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
.input-group {
  margin-bottom: 0.75rem;
}
label {
  display: block;
  margin-bottom: 0.25rem;
  font-weight: bold;
  font-size: 0.875rem;
}
input[type="text"],
select {
  width: 100%;
  padding: 0.5rem;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 0.875rem;
}
.button-group {
  display: flex;
  justify-content: space-between;
}
.button-group button {
  width: 48%;
  padding: 0.5rem;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 0.875rem;
}
.button-group .cancel {
  background-color: #ccc;
  color: #333;
}
.button-group .transfer {
  background-color: #28a745;
  color: #fff;
}
</style>
