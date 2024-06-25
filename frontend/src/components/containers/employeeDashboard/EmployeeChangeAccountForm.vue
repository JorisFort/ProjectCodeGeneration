<script setup>
import {ref} from "vue";

const changePasswordField = ref(false);
const email = ref('');
const phoneNumber = ref('');
const currentPassword = ref('');
const newPassword = ref('');

const showChangePassword = () => {
  changePasswordField.value = true;
}

const handleChangeSubmit = () => {
  const isValid = validateChangeForm();

  if (isValid) {
    submitChangeForm();
  }
}

const handlePasswordSubmit = () => {
  const isValid = validatePasswordForm();

  if (isValid) {
    submitPasswordForm();
  }
}

const validateChangeForm = () => {
  let isValid = true;

  if (!email.value) {
    isValid = false;
    document.querySelector('[name="email"]').setAttribute('aria-invalid', 'true');
  } else {
    document.querySelector('[name="email"]').setAttribute('aria-invalid', 'false');
  }
  if (!phoneNumber.value) {
    isValid = false;
    document.querySelector('[name="phoneNumber"]').setAttribute('aria-invalid', 'true');
  } else {
    document.querySelector('[name="phoneNumber"]').setAttribute('aria-invalid', 'false');
  }
  return isValid;
}

const validatePasswordForm = () => {
  let isValid = true;

  if (!currentPassword.value) {
    isValid = false;
    document.querySelector('[name="currentPassword"]').setAttribute('aria-invalid', 'true');
  } else {
    document.querySelector('[name="currentPassword"]').setAttribute('aria-invalid', 'false');
  }
  if (!newPassword.value) {
    isValid = false;
    document.querySelector('[name="newPassword"]').setAttribute('aria-invalid', 'true');
  } else {
    document.querySelector('[name="newPassword"]').setAttribute('aria-invalid', 'false');
  }

  return isValid;
}

const submitChangeForm = () => {
}

const submitPasswordForm = () => {
}

</script>
<template>

  <form @submit.prevent="handleChangeSubmit">
    <input v-model="email" name="email" placeholder="Email" type="email"/>
    <input v-model="phoneNumber" name="phoneNumber" placeholder="Phone number" type="number"/>
    <button type="submit">Confirm changes</button>
  </form>
  <div v-if="!changePasswordField">
    <button @click="showChangePassword">Change password</button>
  </div>
  <div v-if="changePasswordField">
    <form @submit.prevent="handlePasswordSubmit">
      <input v-model="currentPassword" name="currentPassword" placeholder="Current password" type="password"/>
      <input v-model="newPassword" name="newPassword" placeholder="New password" type="password">
      <button type="submit">Confirm password change</button>
    </form>
  </div>

</template>

<style>
form {
  margin-bottom: 50px;
}
</style>