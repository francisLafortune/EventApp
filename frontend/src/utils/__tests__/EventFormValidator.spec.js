import {validate} from '../EventFormValidator.js'
import {describe, expect, it} from 'vitest'

describe('EventFormValidator', () => {
    it('returns no error is all conditions are respected', () => {
        expect(validate({
            name: "Event name",
            description: "Event description",
            beginTime: "2023-01-01T12:00",
            endTime: "2023-01-01T13:00"
        }).length).toBe(0);
    })

    it('validate required fields', () => {
        expect(validate({
            name: "",
            description: "",
            beginTime: "",
            endTime: ""
        })).toEqual([
            "Le nom doit être renseigné.",
            "La description doit être renseignée.",
            "Les dates de début et de fin doivent être renseignées."
        ]);
    })

    it('returns false if begin time is after end time', () => {
        expect(validate({
            name: "Event name",
            description: "Event description",
            beginTime: "2023-01-01T12:00",
            endTime: "2022-01-01T13:00"
        })).toEqual(["La date de début doit précéder la date de fin."]);
    })
})