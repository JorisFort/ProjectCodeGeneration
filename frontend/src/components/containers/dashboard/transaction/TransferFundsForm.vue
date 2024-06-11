<template>
  <div class="transfer-funds-form">
    <h2>Transfer funds</h2>
    <form @submit.prevent="handleTransfer">
      <div class="input-group">
        <label for="account">Account</label>
        <select id="account" v-model="account" required>
          <option disabled value="">Account Name</option>
          <option>Checking</option>
          <option>Savings</option>
        </select>
      </div>
      <div class="input-group">
        <label for="amount">Amount</label>
        <input
            id="amount"
            v-model="amount"
            placeholder="100,000"
            required
            type="text"
        />
      </div>
      <div class="input-group">
        <label for="card-number">Card Number</label>
        <input
            id="card-number"
            v-model="cardNumber"
            placeholder="0000 0000 0000 0000"
            required
            type="text"
        />
      </div>
      <div class="input-group">
        <label for="card-holder-name">Card holder name</label>
        <input
            id="card-holder-name"
            v-model="cardHolderName"
            placeholder="Enter card holder name"
            required
            type="text"
        />
      </div>
      <div class="input-group">
        <label for="description">Description</label>
        <input
            id="description"
            v-model="description"
            placeholder="Description"
            type="text"
        />
      </div>
      <div class="button-group">
        <button class="cancel" type="button">Cancel</button>
        <button class="transfer" type="submit">Transfer</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import {ref} from "vue";

const account = ref("");
const amount = ref("");
const cardNumber = ref("");
const cardHolderName = ref("");
const description = ref("");

const handleTransfer = () => {
  console.log("Account:", account.value);
  console.log("Amount:", amount.value);
  console.log("Card Number:", cardNumber.value);
  console.log("Card Holder Name:", cardHolderName.value);
  console.log("Description:", description.value);
};
</script>

<style scoped>
.transfer-funds-form {
  max-width: 800px;
  margin: 0.1rem auto;
  padding: 2rem;
  border: 1px solid #ccc;
  border-radius: 5px;
  background: #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.input-group {
  margin-bottom: 0.1rem;
}

label {
  display: block;
  margin-bottom: 0.1rem;
  font-weight: bold;
  font-size: 0.75rem;
}

input[type="text"],
select {
  width: 100%;
  padding: 0.5rem;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 0.75rem;
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
  font-size: 0.75rem; /* Smaller font size */
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
