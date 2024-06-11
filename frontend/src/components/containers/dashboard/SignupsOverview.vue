<script setup>
import {computed, ref} from 'vue';
import SignupsTable from "../../common/SignupsTable.vue";

let signups = [
  {
    id: "a1b2c3d4",
    firstName: "Alice",
    lastName: "Smith",
    bsn: 123456789,
    email: "alice.smith@example.com",
    dateRegistered: "2023-04-10T08:30:00Z"
  },
  {
    id: "e5f6g7h8",
    firstName: "Bob",
    lastName: "Johnson",
    bsn: 987654321,
    email: "bob.johnson@example.com",
    dateRegistered: "2023-06-15T14:45:00Z"
  },
  {
    id: "i9j0k1l2",
    firstName: "Carol",
    lastName: "Williams",
    bsn: 192837465,
    email: "carol.williams@example.com",
    dateRegistered: "2023-09-20T09:15:00Z"
  },
  {
    id: "m3n4o5p6",
    firstName: "David",
    lastName: "Brown",
    bsn: 564738291,
    email: "david.brown@example.com",
    dateRegistered: "2023-11-05T11:00:00Z"
  },
  {
    id: "q7r8s9t0",
    firstName: "Eva",
    lastName: "Davis",
    bsn: 847362514,
    email: "eva.davis@example.com",
    dateRegistered: "2024-01-12T13:25:00Z"
  },
  {
    id: "u1v2w3x4",
    firstName: "Frank",
    lastName: "Miller",
    bsn: 375849201,
    email: "frank.miller@example.com",
    dateRegistered: "2024-03-08T07:50:00Z"
  },
  {
    id: "y5z6a7b8",
    firstName: "Grace",
    lastName: "Wilson",
    bsn: 649182735,
    email: "grace.wilson@example.com",
    dateRegistered: "2024-05-22T16:40:00Z"
  },
  {
    id: "c9d0e1f2",
    firstName: "Henry",
    lastName: "Moore",
    bsn: 583716294,
    email: "henry.moore@example.com",
    dateRegistered: "2024-07-15T10:55:00Z"
  },
  {
    id: "g3h4i5j6",
    firstName: "Ivy",
    lastName: "Taylor",
    bsn: 472615839,
    email: "ivy.taylor@example.com",
    dateRegistered: "2024-09-30T15:05:00Z"
  }
];

const searchQuery = ref('');

const filteredSignups = computed(() => {
  return signups.filter(signup => {
    return Object.values(signup).some(value =>
        value.toString().toLowerCase().includes(searchQuery.value.toLowerCase())
    );
  });
});

</script>

<template>

  <input v-model="searchQuery" placeholder="Search users" type="text"/>
  <SignupsTable :signups="filteredSignups"/>

</template>