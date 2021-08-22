package com.tobiasz.testingservlets.widgets;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;

public class Navbar {

    enum Role {
        USER,
        ADMIN
    }

    private final HttpServletRequest request;

    public Navbar(HttpServletRequest request) {
        this.request = request;
    }

    private List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Home", "/", Role.USER));
        items.add(new Item("Login", "/login", Role.USER));
        return items;
    }

    public List<Item> getMenuItems() {
        Role role = (Role) request.getSession().getAttribute("role");
        List<Item> items = getItems();

        if (role != null && role.equals(Role.ADMIN))
            return items;

        return items.stream()
            .filter(item -> item.getRole().equals(Role.USER))
            .collect(Collectors.toList());
    }

    public class Item {

        private final String name;
        private final String url;
        private final Role role;

        Item(String name, String url, Role role) {
            this.name = name;
            this.url = url;
            this.role = role;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }

        public Role getRole() {
            return role;
        }
    }
}
