<script setup>
import {ref} from "vue";

const confirmDeletion = ref(false)

const confirmingDeletion = () => {
  confirmDeletion.value = true;
}

const noDeletion = () => {
  confirmDeletion.value = false;
};

const deleteAccount = () => {

};

const logOut = () => {

}
</script>

<template>
  <div v-if="!confirmDeletion">
    <p>First name:</p>
    <p>Last name:</p>
    <p>Email: </p>
    <p>Phone number: </p>
    <div class="grid">
      <router-link to="/employeeEditAccount"><button class="employeeButton">Change details</button></router-link>
      <button @click="confirmingDeletion" class="employeeButton">Delete account</button>
      <button @click="logOut" class="employeeButton">Log out</button>
    </div>
  </div>
  <div v-if="confirmDeletion">
    <h3>Are you sure you want to delete your account?</h3>
    <button @click="deleteAccount" class="employeeDeletionButton">Yes</button>
    <button @click="noDeletion" class="employeeDeletionButton">No</button>
  </div>
</template>
