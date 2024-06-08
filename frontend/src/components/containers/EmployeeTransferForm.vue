<script setup>
import {ref} from "vue";

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
  }
  else {
    document.querySelector('[name="senderName"]').setAttribute('aria-invalid', 'false');
  }

  if (!senderAccountNumber.value) {
    isValid = false;
    document.querySelector('[name="senderAccountNumber"]').setAttribute('aria-invalid', 'true');
  }
  else {
    document.querySelector('[name="senderAccountNumber"]').setAttribute('aria-invalid', 'false');
  }

  if (!recipientName.value) {
    isValid = false;
    document.querySelector('[name="recipientName"]').setAttribute('aria-invalid', 'true');
  }
  else {
    document.querySelector('[name="recipientName"]').setAttribute('aria-invalid', 'false');
  }

  if (!recipientAccountNumber.value) {
    isValid = false;
    document.querySelector('[name="recipientAccountNumber"]').setAttribute('aria-invalid', 'true');
  }
  else {
    document.querySelector('[name="recipientAccountNumber"]').setAttribute('aria-invalid', 'false');
  }

  if (!amount.value) {
    isValid = false;
    document.querySelector('[name="amount"]').setAttribute('aria-invalid', 'true');
  }
  else {
    document.querySelector('[name="amount"]').setAttribute('aria-invalid', 'false');
  }

  if (!description.value) {
    isValid = false;
    document.querySelector('[name="description"]').setAttribute('aria-invalid', 'true');
  }
  else {
    document.querySelector('[name="description"]').setAttribute('aria-invalid', 'false');
  }

  return isValid;
}

const submitForm = () => {

}
</script>

<template>
  <form @submit.prevent="handleSubmit">
    <fieldset class="grid">
      <input type="text" name="senderName" placeholder="Name sender" v-model="senderName" aria-invalid=""/>
      <input type="text" name="senderAccountNumber" placeholder="Account number sender" v-model="senderAccountNumber" aria-invalid=""/>
    </fieldset>
    <fieldset class="grid">
      <input type="text" name="recipientName" placeholder="Name recipient" v-model="recipientName" aria-invalid=""/>
      <input type="text" name="recipientAccountNumber" placeholder="Account number recipient" v-model="recipientAccountNumber" aria-invalid=""/>
    </fieldset>
    <input type="number" name="amount" placeholder="Amount" v-model="amount" aria-invalid=""/>
    <input type="text" name="description" placeholder="Description" v-model="description" aria-invalid=""/>
    <button type="submit">Transfer</button>
  </form>
</template>