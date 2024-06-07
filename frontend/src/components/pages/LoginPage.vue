<template>
  <div class="login-container">
    <h2>Login</h2>
    <form @submit.prevent="handleSubmit">
      <div class="form-group">
        <label for="username">Username</label>
        <input
            type="text"
            id="username"
            v-model="username"
            required
        />
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input
            type="password"
            id="password"
            v-model="password"
            required
        />
      </div>
      <button type="submit">Login</button>
    </form>
    <p v-if="errorMessage">{{ errorMessage }}</p>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  name: 'Login',
  setup() {
    const username = ref('');
    const password = ref('');
    const errorMessage = ref('');

    const handleSubmit = () => {
      if (!username.value || !password.value) {
        errorMessage.value = 'Please fill in both fields';
      } else {
        // Perform login action here
        // For example, you can call an API to validate the user credentials
        // Assuming login is successful:
        errorMessage.value = '';
        alert(`Logged in as: ${username.value}`);
        // You can redirect to another page or perform any action here
      }
    };

    return {
      username,
      password,
      errorMessage,
      handleSubmit,
    };
  },
};
</script>
