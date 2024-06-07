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
    <input type="text" name="firstName" placeholder="First name" v-model="firstName" aria-invalid=""/>
    <input type="text" name="lastName" placeholder="Last name" v-model="lastName" aria-invalid="">
    <input type="email" name="email" placeholder="Email" v-model="email" aria-invalid=""/>
    <input type="number" name="absoluteLimit" placeholder="Absolute transfer limit" v-model="absoluteLimit" aria-invalid=""/>
    <input type="number" name="dailyLimit" placeholder="Daily transfer limit" v-model="dailyLimit" aria-invalid=""/>
    <button type="submit">Confirm change</button>
  </form>
</template>