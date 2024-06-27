import {describe, expect, it} from 'vitest'

import {mount} from '@vue/test-utils'
import EventForm from "@/components/EventForm.vue";

describe('EventForm', () => {
    const wrapper = mount(EventForm)
    it('renders properly', () => {
        const wrapper = mount(EventForm)
        expect(wrapper.text()).toContain('Veuillez saisir un nom descriptif de 32 caractères ou moins.')
    })
})