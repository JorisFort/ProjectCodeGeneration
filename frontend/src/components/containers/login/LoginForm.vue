<template>
  <div class="login-form">
    <div v-if="state.error" class="error-box">
      {{ state.error }}
    </div>
    <h2>Login</h2>
    <form @submit.prevent="handleLogin">
      <div class="input-group">
        <label for="email">Email</label>
        <input id="email" v-model="state.email" required type="email"/>
      </div>
      <div class="input-group">
        <label for="password">Password</label>
        <input id="password" v-model="state.password" required type="password"/>
      </div>
      <button type="submit">Login</button>
      <router-link class="register-link" to="/register">Don't have an account? Register</router-link>
    </form>
  </div>
</template>

<script setup>
import {reactive} from "vue";
import {useRouter} from 'vue-router';
import {login} from "@/services/UserService.js";

const router = useRouter();

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
    localStorage.setItem("user", JSON.stringify(response.user));
    if (response.user.role === 'ROLE_EMPLOYEE') {
      await router.push('/employeeDashboard');
    } else if (response.user.role === 'ROLE_CUSTOMER') {
      await router.push('/customerDashboard');
    }
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

.register-link {
  font-size: 0.8rem;
}

.error-box {
  padding: 1rem;
  margin-bottom: 1rem;
  background-color: #f8d7da;
  color: #721c24;
  border: 1px solid #f5c6cb;
  border-radius: 5px;
}
</style>
