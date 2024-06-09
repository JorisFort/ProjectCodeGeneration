<template>
  <div class="login-form">
    <h2>Login</h2>
    <form @submit.prevent="handleLogin">
      <div class="input-group">
        <label for="email">Email</label>
        <input type="email" id="email" v-model="state.email" required />
      </div>
      <div class="input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="state.password" required />
      </div>
      <button type="submit">Login</button>
      <p v-if="state.error" class="error">{{ state.error }}</p>
    </form>
  </div>
</template>

<script setup>
import { reactive } from "vue";
import { login } from "@/services/UserService";

const state = reactive({
  email: "",
  password: "",
  error: "",
});

const handleLogin = async () => {
  state.error = ""; // Reset error message
  try {
    const response = await login(state.email, state.password);
    localStorage.setItem("jwtToken", response.token);
    // TODO: Redirect to the dashboard
  } catch (err) {
    state.error = err.message;
  }
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

.error {
  color: red;
  margin-top: 1rem;
}
</style>
