<template>
  <div class="transfer-funds-form">
    <h2>Transfer funds</h2>
    <form @submit.prevent="handleTransfer">
      <div class="input-group">
        <label for="account">Account</label>
        <select id="account" v-model="account" required>
          <option disabled value="">Account Name</option>
          <option>Account 1</option>
          <option>Account 2</option>
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
        <label for="card-number">Card Number</label>
        <input
          type="text"
          id="card-number"
          v-model="cardNumber"
          placeholder="0000 0000 0000 0000"
          required
        />
      </div>
      <div class="input-group">
        <label for="card-holder-name">Card holder name</label>
        <input
          type="text"
          id="card-holder-name"
          v-model="cardHolderName"
          placeholder="Enter card holder name"
          required
        />
      </div>
      <div class="input-group double">
        <div>
          <label for="transfer-date">Transfer date</label>
          <input
            type="text"
            id="transfer-date"
            v-model="transferDate"
            placeholder="MM/YY"
            required
          />
        </div>
        <div>
          <label for="description">Description</label>
          <input
            type="text"
            id="description"
            v-model="description"
            placeholder="Description"
          />
        </div>
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
const cardNumber = ref("");
const cardHolderName = ref("");
const transferDate = ref("");
const description = ref("");

const handleTransfer = () => {
  // Transfer logic here
  console.log("Account:", account.value);
  console.log("Amount:", amount.value);
  console.log("Card Number:", cardNumber.value);
  console.log("Card Holder Name:", cardHolderName.value);
  console.log("Transfer Date:", transferDate.value);
  console.log("Description:", description.value);
};
</script>

<style scoped>
.transfer-funds-form {
  max-width: 400px; /* Adjust width as needed */
  margin: 2rem auto;
  padding: 2rem;
  border: 1px solid #ccc;
  border-radius: 5px;
  background: #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
.input-group {
  margin-bottom: 1rem;
}
.input-group.double {
  display: flex;
  justify-content: space-between;
}
.input-group.double div {
  width: 48%;
}
label {
  display: block;
  margin-bottom: 0.5rem;
  font-weight: bold;
}
input[type="text"],
select {
  width: 100%;
  padding: 0.5rem;
  border: 1px solid #ccc;
  border-radius: 5px;
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
  font-size: 0.875rem; /* Slightly smaller font */
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
