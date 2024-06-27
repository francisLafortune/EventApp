<script setup>
import {format} from "@/utils/DateFormatter.js";

const props = defineProps(['event'])
const emit = defineEmits(['closeModal'])

function closeModal() {
  emit('closeModal');
}

</script>

<template>
  <!-- The Modal -->
  <div id="myModal" class="modal">


    <!-- Modal content -->
    <div class="modal-content">
      <table class="table">
        <tbody>
        <tr>
          <td class="label">Nom:</td>
          <td>{{ event.name }}</td>
        </tr>
        <tr>
          <td class="label">Début:</td>
          <td>{{ format(event.beginTimestamp) }}</td>
        </tr>
        <tr>
          <td class="label">Fin:</td>
          <td>{{ format(event.endTimestamp) }}</td>
        </tr>
        <tr>
          <td class="label">Description:</td>
          <td>{{ event.description }}</td>
        </tr>
        </tbody>
      </table>
      <div class="d-flex flex-row-reverse">
        <button class="btn btn-primary" @click="closeModal">Fermer</button>
      </div>
    </div>

  </div>
</template>

<style>
/* The Modal (background) */

.label {
  font-weight: bold;
}

.modal {
  display: block; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0, 0, 0); /* Fallback color */
  background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 15% auto; /* 15% from the top and centered */
  padding: 20px;
  border: 1px solid #888;
  width: 60%; /* Could be more or less, depending on screen size */
}


</style>