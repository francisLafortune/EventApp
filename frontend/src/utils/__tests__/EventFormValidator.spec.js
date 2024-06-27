import {validate} from '../EventFormValidator.js'
import {describe, expect, it} from 'vitest'

const eventForm = {
    name: "Event name",
    description: "Event description",
    beginTime: "2023-01-01T12:00",
    endTime: "2023-01-01T13:00"
}

describe('EventFormValidator', () => {
    it('returns true if begin time is before end time', () => {
        expect(validate(eventForm)).toBe(true);
    })
    it('returns false if begin time is after end time', () => {
        eventForm.endTime = "2022-01-01T13:00";
        expect(validate(eventForm)).toBe(false);
    })
})