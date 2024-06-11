<template>
  <div class="user-profile">
    <div class="profile-header">
      <img
          :src="profilePicture"
          alt="Profile Picture"
          class="profile-picture"
      />
      <h2 v-if="!editMode">{{ name }}</h2>
      <input v-else v-model="name" class="edit-input" type="text"/>
    </div>
    <div class="profile-details">
      <p v-if="!editMode"><strong>Email:</strong> {{ email }}</p>
      <input v-else v-model="email" class="edit-input" type="email"/>

      <p v-if="!editMode"><strong>Phone Number:</strong> {{ phone }}</p>
      <input v-else v-model="phone" class="edit-input" type="text"/>

      <p v-if="!editMode"><strong>BSN:</strong> {{ bsn }}</p>
      <input v-else v-model="bsn" class="edit-input" type="text"/>

      <div class="button-group">
        <button v-if="!editMode" class="edit-button" @click="toggleEditMode">
          Edit Profile
        </button>
        <button v-if="!editMode" class="reset-button" @click="resetPassword">
          Reset Password
        </button>
        <button v-if="editMode" class="save-button" @click="saveChanges">
          Save
        </button>
        <button v-if="editMode" class="cancel-button" @click="cancelEdit">
          Cancel
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import {defineEmits, defineProps, ref, watch} from "vue";

const props = defineProps({
  initialProfile: {
    type: Object,
    required: true,
    default: () => ({
      profilePicture: "https://via.placeholder.com/120",
      name: "John Doe",
      email: "johndoe@gmail.com",
      phone: "+31 6 12345678",
      bsn: "9999999999",
    }),
  },
});

const emit = defineEmits(["updateProfile", "resetPassword"]);

const profilePicture = ref(props.initialProfile.profilePicture);
let name = ref(props.initialProfile.name);
let email = ref(props.initialProfile.email);
let phone = ref(props.initialProfile.phone);
let bsn = ref(props.initialProfile.bsn);
let editMode = ref(false);

const originalDetails = {
  name: name.value,
  email: email.value,
  phone: phone.value,
  bsn: bsn.value,
};

watch(
    () => props.initialProfile,
    (newProfile) => {
      profilePicture.value = newProfile.profilePicture;
      name.value = newProfile.name;
      email.value = newProfile.email;
      phone.value = newProfile.phone;
      bsn.value = newProfile.bsn;
      Object.assign(originalDetails, newProfile);
    },
    {deep: true}
);

function toggleEditMode() {
  editMode.value = !editMode.value;
}

function saveChanges() {
  emit("updateProfile", {
    profilePicture: profilePicture.value,
    name: name.value,
    email: email.value,
    phone: phone.value,
    bsn: bsn.value,
  });
  toggleEditMode();
}

function cancelEdit() {
  name.value = originalDetails.name;
  email.value = originalDetails.email;
  phone.value = originalDetails.phone;
  bsn.value = originalDetails.bsn;
  editMode.value = false;
}

function resetPassword() {
  emit("resetPassword");
}
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

.profile-header {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.profile-picture {
  width: 150px;
  height: 150px;
  border-radius: 50%;
  margin-bottom: 1rem;
  object-fit: cover;
  border: 3px solid #28a745;
}

.edit-input {
  width: 90%;
  padding: 0.5rem;
  margin-bottom: 1rem;
}

.button-group {
  display: flex;
  justify-content: center;
  gap: 1rem; /* Adds space between buttons */
}

.edit-button,
.save-button,
.cancel-button,
.reset-button {
  background-color: #28a745;
  color: white;
  padding: 0.5rem 1.5rem;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 1rem;
  transition: background-color 0.3s;
}

.cancel-button,
.reset-button {
  background-color: #dc3545;
}

.edit-button:hover,
.save-button:hover {
  background-color: #218838;
}

.cancel-button:hover,
.reset-button:hover {
  background-color: #c82333;
}
</style>
