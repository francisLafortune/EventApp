import {describe, expect, it} from "vitest";
import {format} from "@/utils/DateFormatter.js";

describe('DateFormatter', () => {
    it('should format date as expected', () => {
        expect(format(1719512160)).toBe("27 juin 2024 à 14:16");
    })
})