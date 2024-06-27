<script setup>
import {format} from "@/utils/DateFormatter.js"

const props = defineProps(['events'])

const emit = defineEmits(['openModal'])

function openModal(event) {
  emit('openModal', event);
}

</script>

<template>
  <ul class="list-group">
    <li v-for="event in events" class="list-group-item">
      <div class="d-flex justify-content-between">
        <div>
          {{ event.name }}
          <br>
          <span class="form-text">{{ format(event.beginTimestamp) }}</span>
        </div>
        <div class="d-flex justify-content-center">
          <button class="btn btn-primary" @click="openModal(event)">Détails</button>
        </div>
      </div>
    </li>
  </ul>
</template>