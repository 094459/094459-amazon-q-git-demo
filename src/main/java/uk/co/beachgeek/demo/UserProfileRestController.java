// SPDX-License-Identifier: MIT
package uk.co.beachgeek.demo;  


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class UserProfileRestController {

    @GetMapping("/api/updateProfile")
    public ResponseEntity<?> updateProfile(@RequestBody UserProfileUpdateRequest request) {
        // Assume there's a service to update the user's email
        // This example directly returns a response entity for simplicity
        return ResponseEntity.ok("Profile updated successfully");
    }

    static class UserProfileUpdateRequest {
        private String email;

        // Getters and Setters
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
