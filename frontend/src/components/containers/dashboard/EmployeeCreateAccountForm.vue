<script setup>
import {ref} from "vue";

const firstName = ref('');
const lastName = ref('');
const email = ref('');
const bsn = ref('');
const password = ref('');

const handleSubmit = () => {
  const isValid = validateForm();
  if (isValid) {
    submitForm();
  }
}

const validateForm = () => {
  let isValid = true;

  if (!firstName.value) {
    isValid = false;
    document.querySelector('[name="firstName"]').setAttribute('aria-invalid', 'true');
  } else {
    document.querySelector('[name="firstName"]').setAttribute('aria-invalid', 'false');
  }

  if (!lastName.value) {
    isValid = false;
    document.querySelector('[name="lastName"]').setAttribute('aria-invalid', 'true');
  } else {
    document.querySelector('[name="lastName"]').setAttribute('aria-invalid', 'false');
  }

  if (!email.value) {
    isValid = false;
    document.querySelector('[name="email"]').setAttribute('aria-invalid', 'true');
  } else {
    document.querySelector('[name="email"]').setAttribute('aria-invalid', 'false');
  }

  if (!bsn.value) {
    isValid = false;
    document.querySelector('[name="bsn"]').setAttribute('aria-invalid', 'true');
  } else {
    document.querySelector('[name="bsn"]').setAttribute('aria-invalid', 'false');
  }

  if (!password.value) {
    isValid = false;
    document.querySelector('[name="password"]').setAttribute('aria-invalid', 'true');
  } else {
    document.querySelector('[name="password"]').setAttribute('aria-invalid', 'false');
  }
  return isValid
}

const submitForm = () => {

}
</script>

<template>
  <form @submit.prevent="handleSubmit">
    <fieldset class="grid">
      <input v-model="firstName" aria-invalid="" name="firstName" placeholder="First name" type="text"/>
      <input v-model="lastName" aria-invalid="" name="lastName" placeholder="Last name" type="text">
    </fieldset>
    <input v-model="email" aria-invalid="" name="email" placeholder="Email" type="email"/>
    <input v-model="bsn" aria-invalid="" name="bsn" placeholder="BSN" type="number"/>
    <input v-model="password" aria-invalid="" name="password" placeholder="Password" type="password"/>
    <button type="submit">Create</button>
  </form>
</template>