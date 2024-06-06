<template>
  <div class="user-profile">
    <div class="profile-header">
      <img
        :src="profilePicture"
        alt="Profile Picture"
        class="profile-picture"
      />
      <h2>{{ name }}</h2>
    </div>
    <div class="profile-details">
      <p><strong>Email:</strong> {{ email }}</p>
      <p><strong>Phone Number:</strong> {{ phone }}</p>
      <p><strong>BSN:</strong> {{ bsn }}</p>
      <button class="reset-password">Reset Password</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";

const profilePicture = ref("path_to_profile_picture.jpg");
const name = ref("John Doe");
const email = ref("johndoe@gmail.com");
const phone = ref("+31 6 12345678");
const bsn = ref("9999999999");
</script>

<style scoped>
.user-profile {
  text-align: center;
}
.profile-header {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.profile-picture {
  width: 100px;
  height: 100px;
  border-radius: 50%;
  margin-bottom: 1rem;
}
.profile-details {
  margin-top: 1rem;
  text-align: left;
}
.profile-details p {
  margin: 0.5rem 0;
}
.reset-password {
  background-color: #28a745;
  color: white;
  padding: 0.5rem 1rem;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
</style>
