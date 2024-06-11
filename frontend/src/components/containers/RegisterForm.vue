<template>
  <div class="register-form">
    <div v-if="error" class="error-box">
      {{ error }}
    </div>
    <h2>Register</h2>
    <form @submit.prevent="handleRegister">
      <div class="input-group">
        <label for="first-name">First Name</label>
        <input
            id="first-name"
            v-model="firstName"
            placeholder="Enter name here"
            required
            type="text"
        />
      </div>
      <div class="input-group">
        <label for="last-name">Last Name</label>
        <input
            id="last-name"
            v-model="lastName"
            placeholder="Enter name here"
            required
            type="text"
        />
      </div>
      <div class="input-group">
        <label for="email">Email</label>
        <input
            id="email"
            v-model="email"
            placeholder="Enter your Email"
            required
            type="email"
        />
      </div>
      <div class="input-group">
        <label for="phoneNumber">Phone number</label>
        <input
            id="phoneNumber"
            v-model="phoneNumber"
            placeholder="Enter your phone number"
            required
            type="text"
        />
      </div>
      <div class="input-group">
        <label for="password">Password</label>
        <input
            id="password"
            v-model="password"
            placeholder="Enter your Password"
            required
            type="password"
        />
      </div>
      <div class="input-group">
        <label for="bsn">BSN</label>
        <input
            id="bsn"
            v-model="bsn"
            placeholder="Enter your BSN"
            required
            type="text"
        />
      </div>
      <div class="terms">
        <input id="terms" v-model="acceptedTerms" required type="checkbox"/>
        <label for="terms"
        >I agree to all the <a href="#">Terms</a>,
          <a href="#">Privacy Policy</a> and <a href="#">Fees</a>.</label
        >
      </div>
      <button type="submit">Register</button>
    </form>
    <p>
      Already have an Account?
      <router-link to="/login">Log in.</router-link>
    </p>
  </div>
</template>

<script setup>
import {ref} from "vue";
import {useRouter} from 'vue-router';
import {register} from "@/services/UserService.js";

const router = useRouter();
const firstName = ref("");
const lastName = ref("");
const email = ref("");
const phoneNumber = ref("");
const password = ref("");
const bsn = ref("");
const acceptedTerms = ref(false);
const error = ref("");

const handleRegister = async () => {
  try {
    error.value = ""; // Reset error message
    const response = await register(email, password, firstName, lastName, bsn, phoneNumber);
    localStorage.setItem("jwtToken", response.token);
    localStorage.setItem("user", response.user);
    if (response.user.role === 'EMPLOYEE') {
      await router.push('/employeeDashboard');
    } else if (response.user.role === 'CUSTOMER') {
      await router.push('/customerDashboard');
    }
  } catch (err) {
    error.value = err.message;
  }
};
</script>

<style scoped>
.register-form {
  max-width: 300px;
  margin: 2rem auto;
  padding: 1rem;
  border: 1px solid #ccc;
  border-radius: 5px;
  background: #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
.input-group {
  margin-bottom: 1rem;
}

label {
  display: block;
  margin-bottom: 0.5rem;
  font-weight: bold;
  font-size: 0.875rem;
}

input[type="text"],
input[type="email"],
input[type="password"] {
  width: 100%;
  padding: 0.5rem;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 0.875rem;
}

.terms {
  margin-bottom: 1rem;
  font-size: 0.875rem;
}

button {
  width: 100%;
  padding: 0.5rem;
  border: none;
  background-color: #28a745;
  color: #fff;
  border-radius: 5px;
  cursor: pointer;
  font-size: 0.875rem;
}

a {
  color: #007bff;
  text-decoration: none;
  font-size: 0.875rem;
}

a:hover {
  text-decoration: underline;
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
