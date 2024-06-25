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
      <router-link to="/employeeEditAccount">
        <button class="employeeButton">Change details</button>
      </router-link>
      <button class="employeeButton" @click="confirmingDeletion">Delete account</button>
      <button class="employeeButton" @click="logOut">Log out</button>
    </div>
  </div>
  <div v-if="confirmDeletion">
    <h3>Are you sure you want to delete your account?</h3>
    <button class="employeeDeletionButton" @click="deleteAccount">Yes</button>
    <button class="employeeDeletionButton" @click="noDeletion">No</button>
  </div>
</template>
