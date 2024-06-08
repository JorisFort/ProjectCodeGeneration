<template>
  <div class="login-container">
    <h2>Login</h2>
    <form @submit.prevent="login">
      <div class="form-group">
        <label for="identifier">Username</label>
        <input type="text" id="identifier" v-model="identifier" required />
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="password" required />
      </div>
      <button type="submit">Login</button>
      <p v-if="errorMessage">{{ errorMessage }}</p>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'LoginPage',
  data() {
    return {
      identifier: '',
      password: '',
      errorMessage: ''
    };
  },
  methods: {
    async login() {
      try {
        const response = await axios.post('https://your-api-url.com/login', {
          identifier: this.identifier,
          password: this.password
        });

        // Assuming the API response contains a JWT token and user email
        const { token, email } = response.data;

        // Store the JWT token in localStorage or vuex
        localStorage.setItem('token', token);
        localStorage.setItem('email', email);

        // Redirect to the ATM page or any other page
        this.$router.push('/atm');
      } catch (error) {
        // Handle error and display message
        this.errorMessage = 'Invalid username/email or password. Please try again.';
      }
    }
  }
};
</script>
