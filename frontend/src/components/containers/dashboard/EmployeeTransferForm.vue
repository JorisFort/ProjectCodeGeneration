<script setup>
import {ref} from "vue";
import {transfer} from "@/services/TransactionService.js"

const senderName = ref('');
const senderAccountNumber = ref('');
const recipientName = ref('');
const recipientAccountNumber = ref('');
const amount = ref('');
const description = ref('');

const handleSubmit = () => {
  const isValid = validateForm();

  if (isValid) {
    submitForm();
  }
}

const validateForm = () => {
  let isValid = true;

  if (!senderName.value) {
    isValid = false;
    document.querySelector('[name="senderName"]').setAttribute('aria-invalid', 'true');
  } else {
    document.querySelector('[name="senderName"]').setAttribute('aria-invalid', 'false');
  }

  if (!senderAccountNumber.value) {
    isValid = false;
    document.querySelector('[name="senderAccountNumber"]').setAttribute('aria-invalid', 'true');
  } else {
    document.querySelector('[name="senderAccountNumber"]').setAttribute('aria-invalid', 'false');
  }

  if (!recipientName.value) {
    isValid = false;
    document.querySelector('[name="recipientName"]').setAttribute('aria-invalid', 'true');
  } else {
    document.querySelector('[name="recipientName"]').setAttribute('aria-invalid', 'false');
  }

  if (!recipientAccountNumber.value) {
    isValid = false;
    document.querySelector('[name="recipientAccountNumber"]').setAttribute('aria-invalid', 'true');
  } else {
    document.querySelector('[name="recipientAccountNumber"]').setAttribute('aria-invalid', 'false');
  }

  if (!amount.value) {
    isValid = false;
    document.querySelector('[name="amount"]').setAttribute('aria-invalid', 'true');
  } else {
    document.querySelector('[name="amount"]').setAttribute('aria-invalid', 'false');
  }

  if (!description.value) {
    isValid = false;
    document.querySelector('[name="description"]').setAttribute('aria-invalid', 'true');
  } else {
    document.querySelector('[name="description"]').setAttribute('aria-invalid', 'false');
  }

  return isValid;
}

const submitForm = async () => {
  const newTransfer = {
    senderName: this.senderName,
    senderAccountNumber: this.senderAccountNumber,
    recipientName: this.recipientName,
    recipientAccountNumber: this.recipientAccountNumber,
    amount: this.amount,
    description: this.description
  }
  try {
    const response = await transfer(newTransfer);
  } catch (err) {
    console.error(err)
  }
}
</script>

<template>
  <form @submit.prevent="handleSubmit">
    <fieldset class="grid">
      <input v-model="senderName" aria-invalid="" name="senderName" placeholder="Name sender" type="text"/>
      <input v-model="senderAccountNumber" aria-invalid="" name="senderAccountNumber" placeholder="Account number sender"
             type="text"/>
    </fieldset>
    <fieldset class="grid">
      <input v-model="recipientName" aria-invalid="" name="recipientName" placeholder="Name recipient" type="text"/>
      <input v-model="recipientAccountNumber" aria-invalid="" name="recipientAccountNumber"
             placeholder="Account number recipient" type="text"/>
    </fieldset>
    <input v-model="amount" aria-invalid="" name="amount" placeholder="Amount" type="number"/>
    <input v-model="description" aria-invalid="" name="description" placeholder="Description" type="text"/>
    <button type="submit">Transfer</button>
  </form>
</template>