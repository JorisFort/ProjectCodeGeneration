<template>
  <div class="register-form">
    <h2>Register</h2>
    <form @submit.prevent="handleRegister">
      <div class="input-group">
        <label for="first-name">First Name</label>
        <input
          type="text"
          id="first-name"
          v-model="firstName"
          placeholder="Enter name here"
          required
        />
      </div>
      <div class="input-group">
        <label for="last-name">Last Name</label>
        <input
          type="text"
          id="last-name"
          v-model="lastName"
          placeholder="Enter name here"
          required
        />
      </div>
      <div class="input-group">
        <label for="email">Email</label>
        <input
          type="email"
          id="email"
          v-model="email"
          placeholder="Enter your Email"
          required
        />
      </div>
      <div class="input-group">
        <label for="password">Password</label>
        <input
          type="password"
          id="password"
          v-model="password"
          placeholder="Enter your Password"
          required
        />
      </div>
      <div class="input-group">
        <label for="phone-number">Phone Number</label>
        <input
          type="text"
          id="phone-number"
          v-model="bsn"
          placeholder="Enter your Phone Number"
          required
        />
      </div>
      <div class="input-group">
        <label for="bsn">BSN</label>
        <input
          type="text"
          id="bsn"
          v-model="bsn"
          placeholder="Enter your BSN"
          required
        />
      </div>
      <div class="terms">
        <input type="checkbox" id="terms" v-model="acceptedTerms" required />
        <label for="terms"
          >I agree to all the <a href="#">Terms</a>,
          <a href="#">Privacy Policy</a> and <a href="#">Fees</a>.</label
        >
      </div>
      <button type="submit">Register</button>
    </form>
    <p>
      Already have an Account? <router-link to="/login">Log in.</router-link>
    </p>
  </div>
</template>

<script setup>
import { ref } from "vue";

const firstName = ref("");
const lastName = ref("");
const email = ref("");
const password = ref("");
const bsn = ref("");
const acceptedTerms = ref(false);

const handleRegister = () => {
  console.log("First Name:", firstName.value);
  console.log("Last Name:", lastName.value);
  console.log("Email:", email.value);
  console.log("Password:", password.value);
  console.log("BSN:", bsn.value);
  console.log("Accepted Terms:", acceptedTerms.value);
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
</style>
