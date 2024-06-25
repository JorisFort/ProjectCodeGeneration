<template>
  <div class="user-profile">
    <div class="profile-details">
      <h2>{{ name }}</h2>
      <p><strong>Email:</strong> {{ email }}</p>
      <p><strong>Phone Number:</strong> {{ phone }}</p>
      <p><strong>BSN:</strong> {{ bsn }}</p>
    </div>
  </div>
</template>

<script setup>
import {defineProps, ref} from "vue";

const props = defineProps({
  customer: {
    type: Object,
    required: true,
    default: () => ({
      firstName: "",
      lastName: "",
      user: {
        email: "",
      },
      phoneNumber: "",
      bsnNumber: "",
    }),
  },
});

let name = ref(props.customer.firstName + " " + props.customer.lastName);
let email = ref(props.customer.user.email);
let phone = ref(props.customer.phoneNumber);
let bsn = ref(props.customer.bsnNumber);
</script>

<style scoped>
.user-profile {
  background-color: #ffffff;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  padding: 2rem;
  max-width: 600px;
  margin: 2rem auto;
  text-align: center;
}
.edit-input {
  width: 90%;
  padding: 0.5rem;
  margin-bottom: 1rem;
}

.button-group {
  display: flex;
  justify-content: center;
  gap: 1rem;
}

.edit-button,
.save-button,
.cancel-button {
  background-color: #28a745;
  color: white;
  padding: 0.5rem 1.5rem;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 1rem;
  transition: background-color 0.3s;
}

.cancel-button {
  background-color: #dc3545;
}

.edit-button:hover,
.save-button:hover {
  background-color: #218838;
}

.cancel-button:hover {
  background-color: #c82333;
}
</style>
