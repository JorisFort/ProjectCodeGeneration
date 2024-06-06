<template>
    <div class="login-form">
      <h2>Login</h2>
      <form @submit.prevent="handleLogin">
        <div class="input-group">
          <label for="email">Email</label>
          <input type="email" id="email" v-model="email" required />
        </div>
        <div class="input-group">
          <label for="password">Password</label>
          <input type="password" id="password" v-model="password" required />
        </div>
        <button type="submit">Login</button>
      </form>
    </div>
  </template>
  
  <script setup>
  import { ref } from "vue";
  
  const email = ref("");
  const password = ref("");
  
  const handleLogin = () => {
    console.log("Email:", email.value);
    console.log("Password:", password.value);
    // Add your login logic here, such as API calls
  };
  </script>
  
  <style scoped>
  .login-form {
    max-width: 300px;
    margin: 0 auto;
    padding: 1rem;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
  .input-group {
    margin-bottom: 1rem;
  }
  label {
    display: block;
    margin-bottom: 0.5rem;
  }
  input {
    width: 100%;
    padding: 0.5rem;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
  button {
    width: 100%;
    padding: 0.5rem;
    border: none;
    background-color: #28a745;
    color: #fff;
    border-radius: 5px;
    cursor: pointer;
  }
  </style>
  