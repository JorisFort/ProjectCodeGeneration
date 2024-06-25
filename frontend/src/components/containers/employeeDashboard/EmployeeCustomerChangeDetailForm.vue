<script setup>
import {useRoute} from "vue-router";
import {ref} from "vue";

const route = useRoute();
const firstName = ref(route.params.id);
const lastName = ref('');
const email = ref('');
const absoluteLimit = ref('');
const dailyLimit = ref('');

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

  if (!absoluteLimit.value) {
    isValid = false;
    document.querySelector('[name="absoluteLimit"]').setAttribute('aria-invalid', 'true');
  } else {
    document.querySelector('[name="absoluteLimit"]').setAttribute('aria-invalid', 'false');
  }

  if (!dailyLimit.value) {
    isValid = false;
    document.querySelector('[name="dailyLimit"]').setAttribute('aria-invalid', 'true');
  } else {
    document.querySelector('[name="dailyLimit"]').setAttribute('aria-invalid', 'false');
  }

  return isValid;
}

const submitForm = () => {
  document.querySelector('#formValues').innerText = `
    First Name: ${firstName.value}
    Last Name: ${lastName.value}
    Email: ${email.value}
    Absolute Transfer Limit: ${absoluteLimit.value}
    Daily Transfer Limit: ${dailyLimit.value}
  `;
}
</script>

<template>
  <form @submit.prevent="handleSubmit">
    <input v-model="firstName" aria-invalid="" name="firstName" placeholder="First name" type="text"/>
    <input v-model="lastName" aria-invalid="" name="lastName" placeholder="Last name" type="text">
    <input v-model="email" aria-invalid="" name="email" placeholder="Email" type="email"/>
    <input v-model="absoluteLimit" aria-invalid="" name="absoluteLimit" placeholder="Absolute transfer limit"
           type="number"/>
    <input v-model="dailyLimit" aria-invalid="" name="dailyLimit" placeholder="Daily transfer limit" type="number"/>
    <button type="submit">Confirm change</button>
  </form>
</template>